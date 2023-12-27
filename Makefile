remove:
	docker rmi $(docker images | grep 'dashboard')
run:
	docker build -t dashboard .
	docker-compose up

push:
	docker build -t dashboard .
	docker tag dashboard:latest hoanghs120/dashboard:latest
	docker push hoanghs120/dashboard:latest