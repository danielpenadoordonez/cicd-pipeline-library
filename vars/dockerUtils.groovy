import clss.ImageSpec

def buildImages(List<ImageSpec> imageSpecs){
    def images = []

    imageSpecs.each{ imageSpec ->
        println("Preparing to build image ${imageSpec}")
        def image = docker.build(imageSpec.name, imageSpec.dockerfilePath)
        images.add(image)
    }

    return images
}

void login(String username, String password, String registry = null){
    if(registry != null){
        sh "docker login ${registry} -u ${username} -p ${password}"
    }
    else {
        sh "docker login -u ${username} -p ${password}"
    }
}

void logout(){
    sh "docker logout"
}

void pushImages(def images){
    images.each{image -> image.push()}
}

void removeImages(List<String> images){
    images.each{image -> sh "docker rmi ${image}"}
}