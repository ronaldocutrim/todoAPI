#!/bin/bash
cd /home/ec2-user
sudo yum install docker -y
sudo systemctl start docker
sudo systemctl enable docker
sudo usermod -aG docker $USER
sudo docker run -d --platform linux/amd64 -p 80:8080 \
-e DATABASE_URL='YOUR_DATABASE_URL' \
-e DATABASE_USERNAME='YOUR_DATABASE_USERNAME' \
-e DATABASE_PASSWORD='YOUR_DATABASE_PASSWORD' \
-e JWT_SECRET='YOUR_JWT_SECRET' \
YOUR_IMAGE_NAME