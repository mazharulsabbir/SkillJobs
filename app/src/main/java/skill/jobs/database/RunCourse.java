package skill.jobs.database;

public class RunCourse {
int id,category_id,is_active;
String name,slug,banner,summary,detail,created_at;
Boolean updated_at,deleted_at;



    public int getId() {
        return id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getIs_active() {
        return is_active;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getBanner() {
        return banner;
    }

    public String getSummary() {
        return summary;
    }

    public String getDetail() {
        return detail;
    }

    public String getCreated_at() {
        return created_at;
    }

    public Boolean getUpdated_at() {
        return updated_at;
    }

    public Boolean getDeleted_at() {
        return deleted_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Boolean updated_at) {
        this.updated_at = updated_at;
    }

    public void setDeleted_at(Boolean deleted_at) {
        this.deleted_at = deleted_at;
    }
}
