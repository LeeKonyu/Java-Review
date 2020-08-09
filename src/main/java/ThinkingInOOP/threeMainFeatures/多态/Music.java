package ThinkingInOOP.threeMainFeatures.多态;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Music
 * @Description TODO
 * @Author
 * @Date 2020/8/9 16:20
 * @Version
 **/

public class Music {
    public static void main(String[] args) {
        List<Instrument> instruments = new ArrayList<Instrument>();
        instruments.add(new Wind());
        instruments.add(new Percussion());
        for (Instrument instrument : instruments){
            instrument.play();
        }
    }
}
