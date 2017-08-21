package myapplications.serry.sooqstars.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import myapplications.serry.sooqstars.R;
import myapplications.serry.sooqstars.apis.Register;
import myapplications.serry.sooqstars.basemodels.SignInBaseModel;
import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.helpers.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_create)
    Button btnCreateAnAccount;
    @BindView(R.id.et_nickname)
    EditText etNickname;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_repassword)
    EditText etRePassword;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.ccp)
    CountryCodePicker ccCountryCode;
    @BindView(R.id.tv_sign_in)
    TextView tvSignIn;
    private String sNickname, sUsername, sEmail, sPassword, sRePassword, sPhone, sCountryCode;
    private Retrofit retrofit;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Intent intent;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        btnCreateAnAccount.setOnClickListener(this);
        tvSignIn.setOnClickListener(this);
        ccCountryCode.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                sCountryCode = ccCountryCode.getSelectedCountryCode();
            }
        });

        editor = sharedPreferences.edit();
        tvSignIn.setTypeface(Constants.getTypeFace(this));
        etNickname.setTypeface(Constants.getTypeFace(this));
        etEmail.setTypeface(Constants.getTypeFace(this));
        etPassword.setTypeface(Constants.getTypeFace(this));
        etPhone.setTypeface(Constants.getTypeFace(this));
        etUsername.setTypeface(Constants.getTypeFace(this));
        etRePassword.setTypeface(Constants.getTypeFace(this));
        btnCreateAnAccount.setTypeface(Constants.getTypeFace(this));

    }

    private boolean validateParams() {
        boolean cancel = true;

        etNickname.setError(null);
        etUsername.setError(null);
        etEmail.setError(null);
        etPassword.setError(null);
        etRePassword.setError(null);
        etPhone.setError(null);


        sPassword = etPassword.getText().toString();
        sRePassword = etPassword.getText().toString();
        sUsername = etUsername.getText().toString();
        sEmail = etEmail.getText().toString();
        sPhone = etPhone.getText().toString();
        sNickname = etNickname.getText().toString();

        if (sNickname.equals("")) {
            etNickname.setError(getResources().getString(R.string.error_field_required));

            cancel = false;
        }
        if (sUsername.equals("")) {
            etUsername.setError(getResources().getString(R.string.error_field_required));

            cancel = false;
        }
        if (sPassword.equals("")) {
            etPassword.setError(getString(R.string.error_field_required));

            cancel = false;
        }
        if (sPassword.length() < 6) {
            etPassword.setError(getString(R.string.error_invalid_password));

            cancel = false;
        }

        if (!sRePassword.equals(sPassword)) {
            etRePassword.setError(getString(R.string.error_password_does_not_match));

            cancel = false;
        }

        if (sEmail.equals("") || !sEmail.contains("@")) {
            etEmail.setError(getString(R.string.error_invalid_email));

            cancel = false;
        }

        if (sPhone.length() != 10) {
            etPhone.setError(getString(R.string.error_incorrect_phone));

            cancel = false;
        }

        return cancel;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_create:
                if (validateParams()) {
                    if (sCountryCode == null)
                        sCountryCode = ccCountryCode.getDefaultCountryCode();
                    Utils.newInstance().showLoading(RegisterActivity.this);
                    register();
                }
                break;
            case R.id.tv_sign_in:
                Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void register() {

        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(Utils.newInstance().getClient(this))
                .build();
        Register registerApi = retrofit.create(Register.class);
        Call<SignInBaseModel> connection = registerApi.register(sNickname, sUsername, sEmail, sPassword, sPhone, sCountryCode);
        connection.enqueue(new Callback<SignInBaseModel>() {
            @Override
            public void onResponse(Call<SignInBaseModel> call, Response<SignInBaseModel> response) {
                Utils.newInstance().dismissLoading();
                try {
                    if (response.body().getAccess_token() != null) {
                        Toast.makeText(getApplicationContext(), "welcome " + response.body().getAccess_token(), Toast.LENGTH_SHORT).show();
                        editor.putBoolean(Constants.isLoggedIn, true);
                        editor.putString(Constants.User_Token, response.body().getAccess_token());
                        editor.commit();
                        intent = new Intent(RegisterActivity.this, MainActivity.class);
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
