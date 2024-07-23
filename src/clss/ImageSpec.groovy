package clss

public class ImageSpec{

    public String name
    public String dockerfilePath
    public String tag

    public ImageSpec(String name, String dockerfilePath, String tag){
        this.name = name
        this.dockerfilePath = dockerfilePath
        this.tag = tag == "" || tag.isAllWhitespace() ? null : tag
    }

    public ImageSpec(String name, String dockerfilePath){
        this.name = name
        this.dockerfilePath = dockerfilePath
        this.tag = null
    }

    public String toString(){
        String imageTag =  ""

        if(this.tag != null){
            imageTag = this.tag
        } else {
            imageTag = "latest"
        }

        return "${this.name}:${imageTag}"
    }
}