package top.gradual.blog.domain.entites;

/**
 * @Description: 种类数量
 * @Author: gradual
 * @Date: 2018-09-06 12:28
 */
public class TypeCount {
    private String type;
    private int count;
    private Long typeId;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TypeCount{" +
                "type='" + type + '\'' +
                ", count=" + count +
                ", typeId=" + typeId +
                '}';
    }
}
