package goodweather.com.goodweather.model.models;

public class WhyModel {
    private String text;
    private String ask;

    public WhyModel(String quest, String answer) {
        this.text = answer;
        this.ask = quest;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

}
