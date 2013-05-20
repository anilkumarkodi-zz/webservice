import com.webservice.domain.GeoCoder;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class JsonTest {

    private String googleDistanceResponse = "" ;

    @Test
    public void shouldReadValuesFromJsonString() throws Exception {
        GeoCoder geoCoder=new GeoCoder();
        String response = geoCoder.getJsonString("chennai", "bangalore", "travel");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readValue(response,JsonNode.class);
        System.out.println(rootNode.get("routes").get(0).get("legs").get(0).get("distance").get("text"));
        System.out.println(rootNode.get("routes").get(0).get("legs").get(0).get("steps").get(1).get("html_instructions"));
    }
}
