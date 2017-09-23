package cn.example.ioj.bean;

import java.util.List;

/**
 * Created by L on 2017/9/23.
 */

public class ProblemsList {

    /**
     * max : 59
     * total : 1161
     * problems : [{"ac":true,"last_submit_time":"2017-09-22 16:07:19","title":"Satellite Photographs ","submit_num":3836,"ac_num":1047,"id":"0001","cloud":["搜索","好难啊不会","我就试一试可以添加书签吗？"]},{"ac":false,"last_submit_time":"2017-09-10 11:42:43","title":"Prime Path      ","submit_num":874,"ac_num":260,"id":"0002","cloud":[]},{"ac":true,"last_submit_time":"2017-08-30 10:23:12","title":"A Bug","submit_num":425,"ac_num":148,"id":"0003","cloud":[]},{"ac":true,"last_submit_time":"2017-08-30 10:27:41","title":"Maze Problem","submit_num":680,"ac_num":290,"id":"0004","cloud":["搜索"]},{"ac":true,"last_submit_time":"2017-09-21 11:37:17","title":"Euclid's Game","submit_num":1923,"ac_num":626,"id":"0005","cloud":[]},{"ac":false,"last_submit_time":"2017-08-30 10:28:31","title":"Y2K Accounting Bug","submit_num":359,"ac_num":66,"id":"0006","cloud":[]},{"ac":false,"last_submit_time":"2017-08-30 10:28:58","title":"Airline Hub","submit_num":124,"ac_num":36,"id":"0007","cloud":[]},{"ac":false,"last_submit_time":"2017-08-30 10:29:20","title":"Snakes","submit_num":71,"ac_num":24,"id":"0008","cloud":[]},{"ac":false,"last_submit_time":"2017-09-11 18:49:32","title":" Snap","submit_num":25,"ac_num":8,"id":"0009","cloud":[]},{"ac":false,"last_submit_time":"2017-08-30 10:29:44","title":"Steps","submit_num":275,"ac_num":101,"id":"0010","cloud":[]},{"ac":false,"last_submit_time":"2017-09-21 11:38:48","title":"Billiard","submit_num":79,"ac_num":48,"id":"0011","cloud":[]},{"ac":false,"last_submit_time":"2017-02-26 22:28:31","title":"The Brick Stops Here","submit_num":107,"ac_num":23,"id":"0012","cloud":[]},{"ac":false,"last_submit_time":"2017-08-30 10:30:27","title":"Election","submit_num":190,"ac_num":37,"id":"0013","cloud":[]},{"ac":false,"last_submit_time":"2017-08-30 10:30:56","title":"Boastin' Red Socks","submit_num":147,"ac_num":30,"id":"0014","cloud":[]},{"ac":true,"last_submit_time":"2017-09-22 23:51:06","title":"A + B","submit_num":11005,"ac_num":4068,"id":"0015","cloud":["水题","16级卓越班选拔A"]},{"ac":false,"last_submit_time":"2015-06-09 20:56:10","title":"Assemble","submit_num":59,"ac_num":15,"id":"0016","cloud":[]},{"ac":false,"last_submit_time":"2016-04-24 18:32:54","title":"March of the Penguins","submit_num":30,"ac_num":9,"id":"0017","cloud":[]},{"ac":false,"last_submit_time":"2017-08-30 10:32:11","title":"Containers","submit_num":65,"ac_num":20,"id":"0018","cloud":[]},{"ac":false,"last_submit_time":"2015-08-04 01:05:35","title":"Youth Hostel Dorm","submit_num":35,"ac_num":3,"id":"0019","cloud":[]},{"ac":true,"last_submit_time":"2017-09-23 00:04:02","title":"A+B Problem","submit_num":4067,"ac_num":2290,"id":"0020","cloud":["水题"]}]
     * page : 1
     */

    private int max;
    private int total;
    private int page;
    private List<ProblemsBean> problems;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<ProblemsBean> getProblems() {
        return problems;
    }

    public void setProblems(List<ProblemsBean> problems) {
        this.problems = problems;
    }

    public static class ProblemsBean {
        /**
         * ac : true
         * last_submit_time : 2017-09-22 16:07:19
         * title : Satellite Photographs
         * submit_num : 3836
         * ac_num : 1047
         * id : 0001
         * cloud : ["搜索","好难啊不会","我就试一试可以添加书签吗？"]
         */

        private boolean ac;
        private String last_submit_time;
        private String title;
        private int submit_num;
        private int ac_num;
        private String id;
        private List<String> cloud;

        public boolean isAc() {
            return ac;
        }

        public void setAc(boolean ac) {
            this.ac = ac;
        }

        public String getLast_submit_time() {
            return last_submit_time;
        }

        public void setLast_submit_time(String last_submit_time) {
            this.last_submit_time = last_submit_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getSubmit_num() {
            return submit_num;
        }

        public void setSubmit_num(int submit_num) {
            this.submit_num = submit_num;
        }

        public int getAc_num() {
            return ac_num;
        }

        public void setAc_num(int ac_num) {
            this.ac_num = ac_num;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getCloud() {
            return cloud;
        }

        public void setCloud(List<String> cloud) {
            this.cloud = cloud;
        }
    }
}
