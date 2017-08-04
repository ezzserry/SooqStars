package myapplications.serry.sooqstars.models;

/**
 * Created by awstreams on 8/3/17.
 */

public class Pager {
    String TotalItems;
    String CurrentPage;
    String PageSize;
    String TotalPages;
    String StartPage;
    String EndPage;

    public String getTotalItems() {
        return TotalItems;
    }

    public void setTotalItems(String totalItems) {
        TotalItems = totalItems;
    }

    public String getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(String currentPage) {
        CurrentPage = currentPage;
    }

    public String getPageSize() {
        return PageSize;
    }

    public void setPageSize(String pageSize) {
        PageSize = pageSize;
    }

    public String getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(String totalPages) {
        TotalPages = totalPages;
    }

    public String getStartPage() {
        return StartPage;
    }

    public void setStartPage(String startPage) {
        StartPage = startPage;
    }

    public String getEndPage() {
        return EndPage;
    }

    public void setEndPage(String endPage) {
        EndPage = endPage;
    }
}
