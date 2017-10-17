package cn.example.ioj.bean;

import java.util.List;

/**
 * Created by wax on 2017/10/14.
 */

public class UserProblemsBean {

    /**
     * num_ac : 0363
     * ch_pros : ["0002","0006","0195","0229","0274","0301","0303","0362","0517","0532","0564","0835","0861","0958","1032","1034","1066","1108","1145"]
     * num_ch : 0019
     * ac_pros : ["0001","0003","0004","0005","0015","0020","0021","0022","0023","0025","0026","0027","0028","0029","0030","0031","0032","0033","0034","0035","0036","0037","0038","0039","0040","0041","0042","0044","0045","0046","0047","0048","0056","0058","0066","0067","0068","0069","0070","0071","0072","0074","0075","0076","0077","0078","0080","0082","0084","0085","0086","0088","0093","0099","0105","0109","0112","0116","0117","0119","0129","0133","0139","0140","0141","0142","0143","0144","0147","0148","0149","0150","0152","0160","0161","0162","0167","0170","0171","0172","0179","0186","0189","0190","0192","0203","0209","0219","0220","0221","0226","0227","0232","0235","0236","0237","0242","0254","0256","0259","0273","0276","0277","0278","0279","0280","0281","0282","0284","0285","0287","0288","0289","0290","0291","0292","0293","0294","0295","0297","0299","0308","0310","0311","0312","0313","0314","0315","0316","0318","0319","0320","0321","0330","0331","0332","0333","0334","0335","0336","0341","0342","0352","0361","0369","0371","0377","0405","0413","0415","0416","0423","0424","0426","0427","0430","0434","0435","0436","0437","0440","0442","0446","0447","0448","0470","0471","0480","0484","0485","0489","0490","0494","0507","0509","0519","0524","0533","0540","0541","0549","0551","0554","0557","0558","0559","0563","0566","0571","0580","0597","0599","0600","0601","0602","0605","0606","0607","0612","0613","0614","0615","0616","0617","0618","0619","0620","0622","0623","0625","0642","0646","0667","0695","0700","0706","0736","0740","0760","0777","0832","0833","0834","0848","0860","0921","0922","0941","0942","0943","0952","0953","0954","0955","0956","0957","0959","0960","0961","0962","0963","0964","0965","0966","0967","0971","0972","0973","0975","0976","0977","0978","0979","0980","0981","0982","0983","0984","0986","0987","1010","1011","1012","1013","1014","1015","1016","1027","1028","1035","1036","1037","1038","1039","1040","1042","1043","1044","1045","1046","1051","1052","1053","1055","1056","1057","1058","1059","1060","1061","1062","1063","1064","1065","1067","1068","1069","1070","1071","1072","1075","1076","1077","1090","1098","1099","1101","1102","1103","1105","1107","1109","1110","1114","1121","1139","1156","1157","1158","1159","1160","1161","1162","1163","1164","1165","1166","1167","1168","1169","1170","1171","1172","1173","1174","1175","1176","1177","1178","1179","1180","1181","1182","1183","1184","1185","1186","1187","1188","1189","1190","1191","1192","1193","1194","1195","1202","1210","1215","1218","1220","1228","1229"]
     * user : 5120160446
     */

    private String num_ac;
    private String num_ch;
    private String user;
    private List<String> ch_pros;
    private List<String> ac_pros;

    public String getNum_ac() {
        return String.valueOf(Integer.valueOf(num_ac));
    }

    public void setNum_ac(String num_ac) {
        this.num_ac = num_ac;
    }

    public String getNum_ch() {
        return String.valueOf(Integer.valueOf(num_ch));
    }

    public void setNum_ch(String num_ch) {
        this.num_ch = num_ch;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<String> getCh_pros() {
        return ch_pros;
    }

    public void setCh_pros(List<String> ch_pros) {
        this.ch_pros = ch_pros;
    }

    public List<String> getAc_pros() {
        return ac_pros;
    }

    public void setAc_pros(List<String> ac_pros) {
        this.ac_pros = ac_pros;
    }
}