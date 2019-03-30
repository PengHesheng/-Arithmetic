package designmodel.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 文档类型， Cloneable就是prototype角色
 * 原型模式 俗称克隆
 * @author PHS
 * @create 2019-03-30 15:08
 **/
public class WordDocument implements Cloneable {
    private String mText;
    private ArrayList<String> mImages = new ArrayList<>();

    public WordDocument() {

    }

    @Override
    protected WordDocument clone() throws CloneNotSupportedException {
        try {
            WordDocument wordDocument = (WordDocument) super.clone();
            wordDocument.mText = this.mText;
            wordDocument.mImages = this.mImages;
            return wordDocument;
        } catch (Exception e) {

        }
        return null;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }

    public List<String> getImages() {
        return mImages;
    }

    public void setImage(String image) {
        mImages.add(image);
    }
}
