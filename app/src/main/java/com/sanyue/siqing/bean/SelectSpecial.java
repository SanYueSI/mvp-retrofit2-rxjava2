package com.sanyue.siqing.bean;

import java.util.List;

/**
 */
public class SelectSpecial extends BaseBean {

    private List<bean> data;

    public List<bean> getData() {
        return data;
    }

    public void setData(List<bean> data) {
        this.data = data;
    }

    public static class bean {
        private String id;
        private String title;
        private String img;
        private String status;
        private String weight;
        private String dtime;
        private int type;
        private String h5url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getDtime() {
            return dtime;
        }

        public void setDtime(String dtime) {
            this.dtime = dtime;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getH5url() {
            return h5url;
        }

        public void setH5url(String h5url) {
            this.h5url = h5url;
        }
    }
}
