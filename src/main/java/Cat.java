import java.io.Serializable;

public class Cat implements Serializable {
    private String rasa;
    private String nickname;
    private double weight;


    public Cat(String rasa, String nickname, double weight) {
        this.rasa = rasa;
        this.nickname = nickname;
        this.weight = weight;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "rasa='" + rasa + '\'' +
                ", nickname='" + nickname + '\'' +
                ", weight=" + weight +
                '}';
    }
}
