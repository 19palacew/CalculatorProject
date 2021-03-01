package model;

import java.math.BigDecimal;

/**
 * Stores and Manipulates Data, specifically it's numerical size and its size category or "type"
 */
public class Bandwidth {
    public enum Type {
        b, kb, mb, gb, tb, B, KB, MB, GB, TB
    }

    private BigDecimal size;
    private Type type;

    /**
     * Creates a new Bandwidth of 0 size of the type bit
     */
    public Bandwidth(){
        size = new BigDecimal("0");
        type = Type.b;
    }

    /**
     * Creates a new Bandwidth of size and type
     * @param size Numerical size of data
     * @param type Size type, (Ex. bits, Bytes, Megabytes)
     */
    public Bandwidth(BigDecimal size, String type){
        this.size = size;
        setType(type);
    }

    public Type getType() {
        return type;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public void setType(String inType){
        switch (inType) {
            case "b" -> type = Type.b;
            case "kb" -> type = Type.kb;
            case "mb" -> type = Type.mb;
            case "gb" -> type = Type.gb;
            case "tb" -> type = Type.tb;
            case "B" -> type = Type.B;
            case "KB" -> type = Type.KB;
            case "MB" -> type = Type.MB;
            case "GB" -> type = Type.GB;
            case "TB" -> type = Type.TB;
        }
    }

    /**
     * Returns a String of Bandwidth
     * @return Makes a String of the size and type in the format "1b"
     */
    public String toString(){
        return size + type.toString();
    }
}
