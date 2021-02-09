package com.Dark.Xmaymay.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Meme {
 @Id
 @GeneratedValue
 private Long id;
 private String name;
 private String caption;
 @Max(value = 500)
 @Min(value = 5)
 private String memeurl;

    public Meme() {
    }

    public Meme(String name, String caption, String url) {
        this.name = name;
        this.caption = caption;
        this.memeurl = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getMemeurl() {
        return memeurl;
    }

    public void setMemeurl(String memeurl) {
        this.memeurl = memeurl;
    }

    @Override
    public String toString() {
        return "com.Dark.Xmaymay.Entity.Meme{" +
                ", name='" + name + '\'' +
                ", caption='" + caption + '\'' +
                ", memeurl='" + memeurl + '\'' +
                '}';
    }
}
