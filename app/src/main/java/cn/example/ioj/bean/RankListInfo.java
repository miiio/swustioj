package cn.example.ioj.bean;

import java.util.List;

/**
 * Created by wax on 2017/10/14.
 */

public class RankListInfo {

    /**
     * ranks : [{"username":"5120160446","maxim":"boji9.cn","submit":1037,"solved":363,"rank_num":25,"avatar":"/media/avatar/7652.jpg"}]
     * max : 1
     * total : 1
     * page : 1
     */

    private int max;
    private int total;
    private int page;
    private List<RanksBean> ranks;

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

    public List<RanksBean> getRanks() {
        return ranks;
    }

    public void setRanks(List<RanksBean> ranks) {
        this.ranks = ranks;
    }

    public static class RanksBean {
        /**
         * username : 5120160446
         * maxim : boji9.cn
         * submit : 1037
         * solved : 363
         * rank_num : 25
         * avatar : /media/avatar/7652.jpg
         */

        private String username;
        private String maxim;
        private int submit;
        private int solved;
        private int rank_num;
        private String avatar;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMaxim() {
            return maxim;
        }

        public void setMaxim(String maxim) {
            this.maxim = maxim;
        }

        public int getSubmit() {
            return submit;
        }

        public void setSubmit(int submit) {
            this.submit = submit;
        }

        public int getSolved() {
            return solved;
        }

        public void setSolved(int solved) {
            this.solved = solved;
        }

        public int getRank_num() {
            return rank_num;
        }

        public void setRank_num(int rank_num) {
            this.rank_num = rank_num;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
