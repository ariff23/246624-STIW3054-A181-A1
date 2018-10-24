import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;


public class Scrapper {
    public static ArrayList<String> list = new ArrayList<String>();

    public ArrayList<String> getArrayList() {

        try {
            Document doc = Jsoup.connect("https://ms.wikipedia.org/wiki/Malaysia").get(); // URL shortened!

            Elements table = doc.select("table.wikitable");// select the table wiki
            Elements rows = table.get(1).select("table.wikitable");//get second table

            for (Element row : rows) {
                // Do something with the "row" variable.
                Elements tds = row.getElementsByTag("th");
                Elements tds1 = row.getElementsByTag("td");

                for (int i = 0; i < tds.size(); i++) {
                    list.add(tds.get(i).text());
                    list.add(tds1.get(i).text());
                }
            }

            for (int g = 0; g <= list.size(); g++) {
                System.out.println(list.get(g) + "  :  " + list.get(g + 1));
                g = g + 1;
            }

        } catch (Exception e) {

        }
        return list;
    }
}



