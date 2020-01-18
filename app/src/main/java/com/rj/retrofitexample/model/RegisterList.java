package com.rj.retrofitexample.model;

public class RegisterList {

    private int U_id;
    private String U_Email;
    private String U_F_Name;
    private String U_L_Name;
    private int U_Reward;
    private int U_Refer_Id;
    private String U_Password;
    private String U_Street;
    private String U_City;
    private String U_Phn;
    private String img;

    public RegisterList(int u_id, String u_Email, String u_F_Name, String u_L_Name, int u_Reward, int u_Refer_Id, String u_Password, String u_Street, String u_City, String u_Phn, String img) {
        U_id = u_id;
        U_Email = u_Email;
        U_F_Name = u_F_Name;
        U_L_Name = u_L_Name;
        U_Reward = u_Reward;
        U_Refer_Id = u_Refer_Id;
        U_Password = u_Password;
        U_Street = u_Street;
        U_City = u_City;
        U_Phn = u_Phn;
        this.img = img;
    }

    public int getU_id() {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public String getU_Email() {
        return U_Email;
    }

    public void setU_Email(String u_Email) {
        U_Email = u_Email;
    }

    public String getU_F_Name() {
        return U_F_Name;
    }

    public void setU_F_Name(String u_F_Name) {
        U_F_Name = u_F_Name;
    }

    public String getU_L_Name() {
        return U_L_Name;
    }

    public void setU_L_Name(String u_L_Name) {
        U_L_Name = u_L_Name;
    }

    public int getU_Reward() {
        return U_Reward;
    }

    public void setU_Reward(int u_Reward) {
        U_Reward = u_Reward;
    }

    public int getU_Refer_Id() {
        return U_Refer_Id;
    }

    public void setU_Refer_Id(int u_Refer_Id) {
        U_Refer_Id = u_Refer_Id;
    }

    public String getU_Password() {
        return U_Password;
    }

    public void setU_Password(String u_Password) {
        U_Password = u_Password;
    }

    public String getU_Street() {
        return U_Street;
    }

    public void setU_Street(String u_Street) {
        U_Street = u_Street;
    }

    public String getU_City() {
        return U_City;
    }

    public void setU_City(String u_City) {
        U_City = u_City;
    }

    public String getU_Phn() {
        return U_Phn;
    }

    public void setU_Phn(String u_Phn) {
        U_Phn = u_Phn;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
