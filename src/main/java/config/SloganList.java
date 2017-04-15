package config;

import java.util.Random;

/**
 * Created by Jiayiwu on 17/4/15.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class SloganList {

    static {
        recommend();
    }

    private static  String[] slogan = {"幸得识卿桃花面，自此阡陌多暖春",
            "想要我的财宝吗？去吧，我把一切全都放在了那里——伟大航路",
            "我是要成为海贼王的男人！",
    "我是时代的残党,新世界里没有能载我的船",
            "我的船下没有手下，只有伙伴。",
            "少年侠气，交结五都雄。肝胆洞，毛发耸。死生同，立谈中，一诺千金重",
            "In me the tiger sniffs the rose.",
            "If you think you can, you can. ",
            "Everything will be OK in the end, if it's not OK, it's not the end.",
            "Stay foolish Stay hungry",
            "致虚极，守静笃。",
            "物有所不足，智有所不明。",
            "求知若饥，虚心若愚。",
    "人的梦想，永远不会结束！",
    "所谓理想，只是同时拥有实力的人才能说的“现实”。所谓弱就是一种罪。","不知所措，才是人生。",
            "海军是正义?海贼是邪恶?这种观念早就过时了!正义必胜?这是当然的啊，因为只有胜者，才是正义啊!",
            "我会连她那份一起变强，我会强到名字响彻天堂的!我会成为世界第一的大剑豪！这是我们说好的！",
            "正义必胜吗？当然，胜利的就是正义。"
    };
    private static  String recommendWord = "";

    public static void recommend(){
        Random random = new Random();
        int tem = random.nextInt(slogan.length);
        recommendWord = slogan[tem];
    }

    public static String getRecommendWord() {
        return recommendWord;
    }

    public static void setRecommendWord(String recommendWord) {
        SloganList.recommendWord = recommendWord;
    }
}
