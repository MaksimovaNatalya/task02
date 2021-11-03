package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria {

    private String groupSearchName;
    private Map<String, Object> criteria = new HashMap<String, Object>();

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public Map<String, Object> getCriteria() {
        return criteria;
    }

    public void add(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }


    public Set entrySet() {
        return criteria.entrySet();
    }


}
