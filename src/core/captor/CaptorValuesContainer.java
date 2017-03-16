package core.captor;

import core.util.ValuesContainer;

/**
 * Created by chouaib on 20/02/17.
 */
public class CaptorValuesContainer implements ValuesContainer {

    private Integer value;
    private Double time;

    public CaptorValuesContainer(Integer value, Double time) {
        this.value = value;
        this.time = time;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Double getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "ValueContainer[" + value + "|" + time + "]";
    }
}
