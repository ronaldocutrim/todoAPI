#!/bin/bash

# Verificar se o script está sendo executado como root
if [ "$(id -u)" != "0" ]; then
    echo "Este script precisa ser executado como root." 1>&2
    exit 1
fi

# Nome do container
container_name="todo_api"

# Verificar se o Docker está instalado
if ! command -v docker &> /dev/null; then
    echo "Instalando Docker..."
    sudo yum install docker -y
fi

# Iniciar o Docker
echo "Iniciando o serviço Docker..."
sudo systemctl start docker

# Habilitar o Docker para iniciar na inicialização do sistema
echo "Habilitando o serviço Docker para iniciar na inicialização do sistema..."
sudo systemctl enable docker

# Adicionar o usuário ao grupo Docker
echo "Adicionando o usuário ao grupo Docker..."
sudo usermod -aG docker $USER

# Verificar se a instalação do Docker foi bem-sucedida
if ! command -v docker &> /dev/null; then
    echo "Falha ao instalar o Docker. Verifique a conexão com a internet ou o repositório do Docker."
    exit 1
fi

# Parar o container se estiver em execução
if sudo docker ps -a --format '{{.Names}}' | grep -Eq "^${container_name}\$"; then
    echo "Parando o container existente..."
    sudo docker stop $container_name
fi

# Atualizar a imagem
echo "Atualizando a imagem..."
sudo docker pull YOUR_IMAGE_NAME

# Remover o container existente, se estiver presente
if sudo docker ps -a --format '{{.Names}}' | grep -Eq "^${container_name}\$"; then
    echo "Removendo o container existente..."
    sudo docker rm $container_name
fi

# Executar o contêiner
echo "Executando o contêiner..."
sudo docker run --name $container_name -d --platform linux/amd64 -p 80:8080 \
-e DATABASE_URL='YOUR_DATABASE_URL' \
-e DATABASE_USERNAME='YOUR_DATABASE_USERNAME' \
-e DATABASE_PASSWORD='YOUR_DATABASE_PASSWORD' \
-e JWT_SECRET='YOUR_JWT_SECRET' \
YOUR_IMAGE_NAME
