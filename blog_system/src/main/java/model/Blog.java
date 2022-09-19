package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

//每个blog对象，对应blog表中的一条数据
public class Blog {
    private int blogId;
    private String title;
    private String content;
    private int userId;
    private Timestamp postTime;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public Timestamp getPostTime() {
//        return postTime;
//    }

    //把这里的getter方法给修改了，不是返回一个时间戳，而是返回一个String（格式化好的时间）
    public String getPostTime(){
        //使用这个类完成时间戳到日期化转换
        //此处的格式如果记不住，要查一下
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(this.postTime);
    }
    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }
}
