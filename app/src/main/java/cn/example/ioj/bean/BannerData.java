package cn.example.ioj.bean;

import java.util.List;

/**
 * Created by L on 2017/9/21.
 */

public class BannerData {

    private List<BannerdataBean> bannerdata;

    public List<BannerdataBean> getBannerdata() {
        return bannerdata;
    }

    public void setBannerdata(List<BannerdataBean> bannerdata) {
        this.bannerdata = bannerdata;
    }

    public static class BannerdataBean {
        /**
         * title : banner1
         * image : http://boji9.cn/ioj/1.jpg
         * url :
         */

        private String title;
        private String image;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
