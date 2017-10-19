package cn.example.ioj.bean;

import java.util.List;

/**
 * Created by Tolean on 2017/10/18.
 */

public class ProblemBean {

    /**
     * id : 34
     * title : 计算函数
     * limit_time : 1000
     * limit_mem : 65535
     * submission : 7114
     * accepted : 4287
     * prblem_content : 有一个函数y={ x      x<1    | 2x-1   1<=x<10    \ 3x-11  x>=10 写一段程序，输入x，输出y
     * problem_input : 一个整数x
     * problem_output : 一个整数y
     * problem_samp_input : 14
     * problem_samp_output : 31
     * problem_hint : 使用函数
     * problem_source :
     * tags : ["水题","14级卓越班选拔A","15级卓越班选拔A","16级卓越班选拔A"]
     */

    private int id;
    private String title;
    private int limit_time;
    private int limit_mem;
    private int submission;
    private int accepted;
    private String prblem_content;
    private String problem_input;
    private String problem_output;
    private String problem_samp_input;
    private String problem_samp_output;
    private String problem_hint;
    private String problem_source;
    private List<String> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLimit_time() {
        return limit_time;
    }

    public void setLimit_time(int limit_time) {
        this.limit_time = limit_time;
    }

    public int getLimit_mem() {
        return limit_mem;
    }

    public void setLimit_mem(int limit_mem) {
        this.limit_mem = limit_mem;
    }

    public int getSubmission() {
        return submission;
    }

    public void setSubmission(int submission) {
        this.submission = submission;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public String getPrblem_content() {
        return prblem_content;
    }

    public void setPrblem_content(String prblem_content) {
        this.prblem_content = prblem_content;
    }

    public String getProblem_input() {
        return problem_input;
    }

    public void setProblem_input(String problem_input) {
        this.problem_input = problem_input;
    }

    public String getProblem_output() {
        return problem_output;
    }

    public void setProblem_output(String problem_output) {
        this.problem_output = problem_output;
    }

    public String getProblem_samp_input() {
        return problem_samp_input;
    }

    public void setProblem_samp_input(String problem_samp_input) {
        this.problem_samp_input = problem_samp_input;
    }

    public String getProblem_samp_output() {
        return problem_samp_output;
    }

    public void setProblem_samp_output(String problem_samp_output) {
        this.problem_samp_output = problem_samp_output;
    }

    public String getProblem_hint() {
        return problem_hint;
    }

    public void setProblem_hint(String problem_hint) {
        this.problem_hint = problem_hint;
    }

    public String getProblem_source() {
        return problem_source;
    }

    public void setProblem_source(String problem_source) {
        this.problem_source = problem_source;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
