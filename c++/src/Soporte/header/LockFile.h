#ifndef LOCKFILE_H_
#define LOCKFILE_H_

#include <unistd.h>
#include <fcntl.h>
#include <string.h>

#define	NOMBRE_ARCHIVO	"logger.txt"

class LockFile {


private:

	struct flock fl;
	int fd;
	char nombre [ 255 ];

public:

	LockFile ( char* nombre );
	virtual ~LockFile();

	int takeLock ();
	int freeLock ();
	int writelock ( char* buffer,int buffsize );
};

#endif /* LOCKFILE_H_ */
