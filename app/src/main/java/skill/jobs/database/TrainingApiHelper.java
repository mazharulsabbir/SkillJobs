package skill.jobs.database;

public class TrainingApiHelper {
    private int id, category_id, is_active;
    private String name, slug, banner, summary, created_at;
    private Boolean updated_at, deleted_at;

    private String detail;

    public TrainingApiHelper() {
    }

    public TrainingApiHelper(int id, int category_id, int is_active, String name, String slug, String banner, String summary, String created_at, Boolean updated_at, Boolean deleted_at, String detail) {
        this.id = id;
        this.category_id = category_id;
        this.is_active = is_active;
        this.name = name;
        this.slug = slug;
        this.banner = banner;
        this.summary = summary;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Boolean getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Boolean updated_at) {
        this.updated_at = updated_at;
    }

    public Boolean getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Boolean deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
