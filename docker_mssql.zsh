sudo systemctl start docker
sudo docker images
sudo docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=r00t.R00T" -p 1433:1433 -d mcr.microsoft.com/mssql/server:latest
sudo docker ps