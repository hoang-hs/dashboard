remove:
	docker rmi $(docker images | grep 'dashboard')
run:
	docker build -t dashboard .
	docker-compose up