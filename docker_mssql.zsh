sudo systemctl start docker
sudo docker images
sudo docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=r00t.R00T" -p 14333:1433 -d 010a534cdc79
sudo docker ps