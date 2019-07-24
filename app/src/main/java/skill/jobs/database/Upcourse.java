package skill.jobs.database;

public class Upcourse {
int id,category_id,is_active;
String name,slug,banner,summary,detail,created_at;
Boolean updated_at,deleted_at;

    public Upcourse(int id, int category_id, int is_active, String name, String slug, String banner, String summary, String detail, String created_at, Boolean updated_at, Boolean deleted_at) {
        this.id = id;
        this.category_id = category_id;
        this.is_active = is_active;
        this.name = name;
        this.slug = slug;
        this.banner = banner;
        this.summary = summary;
        this.detail = detail;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }


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


}
