package myapplications.serry.sooqstars.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import myapplications.serry.sooqstars.R;
import myapplications.serry.sooqstars.apis.SignIn;
import myapplications.serry.sooqstars.basemodels.SignInBaseModel;
import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.helpers.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_sign_in)
    Button btnSignIn;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    private String sUsername, sPassword;
    private Retrofit retrofit;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences(Constants.MyPrefs, 0);
        editor = sharedPreferences.edit();
        btnSignIn.setOnClickListener(this);
    }

    private boolean validateParams() {
        boolean cancel = true;
        etUsername.setError(null);
        etPassword.setError(null);
        sPassword = etPassword.getText().toString();
        sUsername = etUsername.getText().toString();
        if (sUsername.equals("")) {
            etUsername.setError(getResources().getString(R.string.error_field_required));
            etUsername.requestFocus();
            cancel = false;
        }
        if (sPassword.equals("")) {
            etPassword.setError(getString(R.string.error_field_required));
            etPassword.requestFocus();
            cancel = false;
        }
        if (sPassword.length() < 6) {
            etPassword.setError(getString(R.string.error_invalid_password));
            etPassword.requestFocus();
            cancel = false;
        }
        return cancel;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_in:
                if (validateParams())
                    signIn();
                break;
        }
    }

    private void signIn() {
        Utils.newInstance().showLoading(SignInActivity.this);
        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(Utils.newInstance().getClient(this))
                .build();
        SignIn signInApi = retrofit.create(SignIn.class);
        Call<SignInBaseModel> connection = signInApi.signIn(sUsername, sPassword);
        connection.enqueue(new Callback<SignInBaseModel>() {
            @Override
            public void onResponse(Call<SignInBaseModel> call, Response<SignInBaseModel> response) {
                Utils.newInstance().dismissLoading();
                try {
                    if (response.body().getAccess_token() != null) {
                        Toast.makeText(getApplicationContext(), "welcome " + response.body().getDisplayName(), Toast.LENGTH_SHORT).show();
                        editor.putBoolean(Constants.isLoggedIn, true);
                        editor.putString(Constants.User_Token, response.body().getAccess_token());
                        editor.commit();
                        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                } catch (NullPointerException e) {
                    String status = response.message().toString();
                    Toast.makeText(getApplicationContext(), status, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignInBaseModel> call, Throwable t) {
                Utils.newInstance().dismissLoading();
                Toast.makeText(getApplicationContext(), "no internet connection", Toast.LENGTH_SHORT).show();

            }
        });
    }
}