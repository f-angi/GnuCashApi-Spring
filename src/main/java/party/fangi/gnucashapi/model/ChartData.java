package party.fangi.gnucashapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChartData {
    private List<String> labels = new ArrayList<>();
    private List<DataSet> datasets = new ArrayList<>();

    @Data
    @AllArgsConstructor
    public static class DataSet {
        private String label;
        private List<Float> data;
    }
}