package com.lightningsports.SettingsReader;

import org.xml.sax.Attributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class AppKey extends Object {
    private String key;
    private HashMap attributes;
    private ArrayList value;

    public AppKey() {
        key=new String();
        value=new ArrayList();
    }
    
    public AppKey(String key) {
        this.key = key;
        value=new ArrayList();
    }

    public AppKey(String key, Attributes attributes) {
        this.key = key;
        this.attributes = toHashMap(attributes);
        value=new ArrayList();
    }

    public void addAttributes(Attributes attributes) {
        this.attributes=toHashMap(attributes);
    }

    public HashMap getAttributes() {
        return attributes;
    }

    public void addValue(Object value) {
        this.value.add(value);
    }

    public void addValue(String key, Object value) {
        AppKey newKey=new AppKey(key);
        newKey.addValue(value);
        this.value.add(newKey);
    }

    public void addValue(String key, Attributes attributes, Object value) {
        AppKey newKey=new AppKey(key,attributes);
        newKey.addValue(value);
        this.value.add(newKey);
    }

    public void updateValue(Object value) {
        if (this.value.size()==1) this.value.set(0,value);
    }

    public void updateValue(String key, Object value) {
        for (Object appKey: this.value)
            if (appKey.getClass()==AppKey.class)
                if (key.equals(((AppKey) appKey).getKey()) && ((AppKey) appKey).getValues().size()==1)
                    ((AppKey) appKey).updateValue(value);
    }

    public void removeKey(String key) {
        for (int i=0;i<this.value.size();i++)
            if (this.value.get(i).getClass()==AppKey.class)
                if (key.equals(((AppKey) this.value.get(i)).getKey()))
                    this.value.remove(i);
    }

    public void removeKey(String key, Attributes attributes) {
        removeKey(key,toHashMap(attributes));
    }

    public void removeKey(String key, HashMap attributes) {

        for (int i=0;i<value.size();i++)
            if (value.get(i).getClass()==AppKey.class) {
                if (key.equals(((AppKey) value.get(i)).getKey()) && ((AppKey) value.get(i)).compareAttributes(attributes))
                    this.value.remove(i);
            }
    }

    public ArrayList getValues() {
        return value;
    }

    public String getValue(String key) {

        for (int i=0;i<value.size();i++)
            if (value.get(i).getClass()==AppKey.class)
                if (key.equals(((AppKey) value.get(i)).getKey()) && ((AppKey) value.get(i)).getValues().size()==1)
                    return (String) (((AppKey) value.get(i)).getValues().get(0));
        return (String) null;
    }

    public String getValue(String key, Attributes attributes) {
        return getValue(key,toHashMap(attributes));
    }

    public String getValue(String key, HashMap attributes) {
        AppKey tempKey;

        for (int i=0;i<value.size();i++)
            if (value.get(i).getClass()==AppKey.class) {
                tempKey=(AppKey) value.get(i);
                if (key.equals(tempKey.getKey()) && tempKey.compareAttributes(attributes) && tempKey.getValues().size()==1)
                    return (String) (tempKey.getValues().get(0));
            }
        return (String) null;
    }

    public ArrayList getValues(String key) {
        ArrayList tempList;

        tempList=new ArrayList();
        for (int i=0;i<value.size();i++)
            if (value.get(i).getClass()==AppKey.class)
                if (key.equals(((AppKey) value.get(i)).getKey()))
                    tempList.add((AppKey) value.get(i));
        if (tempList.size()==0)
            return (ArrayList) null;
        else
            return tempList;
    }

    public AppKey getValues(String key, Attributes attributes) {
        return getValues(key,toHashMap(attributes));
    }

    public AppKey getValues(String key, HashMap attributes) {
        AppKey tempKey;

        for (int i=0;i<value.size();i++) {
            if (value.get(i).getClass()==AppKey.class) {
                tempKey=(AppKey) value.get(i);
                if (key.equals(tempKey.getKey()) && tempKey.compareAttributes(attributes))
                    return tempKey;
            }
        }
        return (AppKey) null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAttribute(String name) {
        return (String) attributes.get(name);
    }

    public AppKey findKey(String key, Attributes attributes) {
        AppKey tempKey;

        for (int i=0;i<value.size();i++) {
            if (value.get(i).getClass()==AppKey.class) {
                tempKey=(AppKey) value.get(i);
                if (key.equals(tempKey.getKey()) && tempKey.compareAttributes(attributes))
                    return tempKey;
            }
        }
        value.add(new AppKey(key,attributes));
        return (AppKey) value.get(value.size()-1);
    }

    private HashMap toHashMap(Attributes attributes) {
        HashMap tempMap=new HashMap();
        for (int i=0; i<attributes.getLength();i++)
            tempMap.put(attributes.getQName(i),attributes.getValue(i));
        return tempMap;
    }

    public boolean compareAttributes(Attributes attributes) {
        HashMap tempAttributes=(HashMap) this.attributes.clone();
        Set valueKeys=tempAttributes.keySet();

        for (int i=0;i<attributes.getLength();i++) {
            if (this.attributes.containsKey(attributes.getQName(i))) {
                if ((this.attributes.get(attributes.getQName(i))).equals(attributes.getValue(i))) {
                    valueKeys.remove(attributes.getQName(i));
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return valueKeys.size()==0;
    }

    public boolean compareAttributes(HashMap attributes) {
        HashMap tempAttributes=(HashMap) this.attributes.clone();
        Set valueKeys=tempAttributes.keySet();

        for (Object key: attributes.keySet()) {
            if (this.attributes.containsKey((String) key)) {
                if ((this.attributes.get((String) key)).equals(attributes.get((String) key))) {
                    valueKeys.remove((String) key);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return valueKeys.size()==0;
    }

    public boolean equals(Object obj) {
        AppKey tempKey;
        if (obj.getClass()==AppKey.class) {
            tempKey=(AppKey) obj;
             return (tempKey.getKey().equals(key) && tempKey.getAttributes().equals(attributes) && tempKey.getValues().equals(value));
        } else if (obj.getClass()==String.class) {
            return ((String) obj).equals(key);
        } else
            return false;
    }

    public String toString() {
        if (attributes==null && value==null)
            return key+":null attributes:null values";
        else if (attributes==null && value!=null)
            return key+":null attributes:"+value.toString();
        else if (attributes!=null && value==null)
            return key+":"+attributes.toString()+":null values";
        else
            return key+":"+attributes.toString()+":"+value.toString();
    }

}
