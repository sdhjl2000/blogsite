## BUILDING
##   (from project root directory)
##   $ docker build -t java-for-sdhjl2000-blogsite .
##
## RUNNING
##   $ docker run java-for-sdhjl2000-blogsite

FROM gcr.io/bitnami-containers/minideb-extras:jessie-r14-buildpack

MAINTAINER Bitnami <containers@bitnami.com>

ENV STACKSMITH_STACK_ID="tsyhdy4" \
    STACKSMITH_STACK_NAME="Java for sdhjl2000/blogsite" \
    STACKSMITH_STACK_PRIVATE="1"

# Install required system packages
RUN install_packages libc6 libx11-6 libxcb1 libxau6 libxdmcp6 libgcc1 libglib2.0-0 libffi6 libpcre3 libxext6 libstdc++6 zlib1g libselinux1 libxml2 liblzma5

RUN bitnami-pkg install java-1.8.131-0 --checksum 5b122a36c8ba44e2f9eb8cbb9b62dd87963742c46f85a04019115d2d43c69e33

ENV PATH=/opt/bitnami/java/bin:$PATH \
    JAVA_HOME=/opt/bitnami/java

## STACKSMITH-END: Modifications below this line will be unchanged when regenerating

# Java base template
COPY . /app
WORKDIR /app
