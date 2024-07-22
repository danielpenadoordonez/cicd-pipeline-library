public class ImageSpec{

    public String name
    public String dockerfilePath
    public String tag

    public ImageSpec(String name, String dockerfilePath, String tag){
        this.name = name
        this.dockerfilePath = dockerfilePath
        this.tag = tag
    }

    public ImageSpec(String name, String dockerfilePath){
        this.name = name
        this.dockerfilePath = dockerfilePath
        this.tag = null
    }

    @overried
    public String toString(){
        String imageTag = tag != null || tag != "" ? this.tag : ""
        return "${this.name}:${this.tag}"
    }
}