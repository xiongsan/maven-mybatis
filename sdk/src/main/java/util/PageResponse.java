package util;

import java.util.List;

/**
 * Created by zhouwei on 2017/3/30.
 */
public class PageResponse<T> {
    List<T> data;
    private int recordsTotal;
    private int recordsFiltered;

    public static <T> PageResponse<T> wrap(List<T> page,int no,int size) {
        PageResponse<T> response = new PageResponse<T>();
        response.setRecordsTotal(page.size());
        response.setRecordsFiltered(page.size());
        if(no*size>page.size()){
           page=page.subList((no-1)*size,page.size());
        }
        else{
            page = page.subList((no-1)*size,(no-1)*size+size);
        }
        response.setData(page);
        return response;
    }


    public void setData(List<T> data) {
        this.data = data;
    }


    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }


    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
