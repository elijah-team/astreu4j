# spontaneous-failure

- Test of https://github.com/eigr/astreu4j
- Can't get this to work
  - Junit green, but...
  - Yes, I tried with docker

```bash
podman run --rm --net=host -e RELEASE_NODE=unique_name_peer_node docker.io/eigr/astreu:0.1.2
```

```bash
git clone https://github.com/elijah-team/astreu4j
cd astreu4j
mvn clean test
``` 
