package com.example.quanlinhanvien.service;

import com.example.quanlinhanvien.models.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienService implements IService<NhanVien> {

    List<NhanVien> nhanViens = new ArrayList<>();

    {
        nhanViens.add(new NhanVien(1, "Ngọc", 25, "https://gocyeube.com/wp-content/uploads/2022/05/anh-body-nu-dep-chat-che-mat-3-min.jpg"));
        nhanViens.add(new NhanVien(2, "Hiệp", 30, "https://gocyeube.com/wp-content/uploads/2022/05/anh-body-nu-dep-chat-che-mat-3-min.jpg"));
        nhanViens.add(new NhanVien(3, "Mai", 27, "https://gocyeube.com/wp-content/uploads/2022/05/anh-body-nu-dep-chat-che-mat-3-min.jpg"));
        nhanViens.add(new NhanVien(4, "Bé Diệp", 18, "https://scontent.fhan2-2.fna.fbcdn.net/v/t1.6435-9/47260140_1148300801992355_4158985358643560448_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=bWndvFaBfssAX8Ym44D&_nc_ht=scontent.fhan2-2.fna&oh=00_AfAMeNX9R95OgYs5oz7SIBs1J-xeh3KRu3M4-88ArbQmvg&oe=6380B5DB"));
    }

    @Override
    public List<NhanVien> showAll() {
        return nhanViens;
    }

    @Override
    public NhanVien findById(int id) {
        for (NhanVien nhanVien : nhanViens) {
            if (nhanVien.getId() == id) {
                return nhanVien;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getId() == id) {
                nhanViens.remove(i);
            }
        }
    }


    @Override
    public void editById(int id, NhanVien nhanVien) {

        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getId() == id) {
                nhanViens.set(i, nhanVien);
            }
        }
    }


    @Override
    public void create(NhanVien nhanVien) {
        nhanViens.add(nhanVien);
    }
}
