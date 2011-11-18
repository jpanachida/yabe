package models;
 
import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.StringUtils;
 
import play.data.validation.*;
import play.db.jpa.*;
 
@Entity
public class Comment extends Model {
 
	@Required
    public String author;
	@Required
    public Date postedAt;
     
    @Lob
    @Required
    @MaxSize(10000)
    public String content;
    
    @ManyToOne
    @Required
    public Post post;
    
    public Comment(Post post, String author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
        this.postedAt = new Date();
    }
 
    public String toString() {
        return String.format("%s: %s...", author, StringUtils.substring(content, 0, 64));
    }
}