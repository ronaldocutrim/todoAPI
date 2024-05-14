copy:
	scp startup.sh ec2-user@3.140.253.115:/home/ec2-user
deploy:
	docker build --platform linux/amd64 -t ronaldocutrim/todo_api . && docker push ronaldocutrim/todo_api
connect:
	ssh ec2-user@3.140.253.115
