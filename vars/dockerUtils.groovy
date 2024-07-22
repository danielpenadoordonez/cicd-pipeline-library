import clss.ImageSpec

def build_images(List<ImageSpec> imageSpecs){
    def images = []

    imageSpecs.each{ imageSpec ->
        println "Preparing to build image ${imageSpec}"
        def image = docker.build(imageSpec.getName(), imageSpec.dockerfilePath)
        images.add(image)
    }

    return images
}