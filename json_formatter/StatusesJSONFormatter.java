package json_formatter;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pet.status.Status;
import com.pet.status.StatusName;

import org.json.JSONArray;
import org.json.JSONObject;

public class StatusesJSONFormatter {
    public static String toJSON(Map<StatusName, Status> statuses) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "statuses");

        Stream<Map.Entry<StatusName, Status>> entriesStream = statuses.entrySet().stream();
        Collection<JSONObject> list = entriesStream.map(entry -> new JSONObject().put("name", entry.getKey().toString())
                .put("value", entry.getValue().getValue())).collect(Collectors.toList());

        jsonObject.put("statuses", new JSONArray(list));
        return jsonObject.toString();
    }

}
