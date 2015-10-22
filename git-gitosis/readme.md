### add git user

>[root@localhost]useradd -m git

### change git passwd

>[root@localhost]passwd git

### add git user to sudo 

>[root@localhost]visudo

#### to the end line insert
>git    ALL=(ALL)       ALL

### sudo git

>sudo git

### add git repositories folder

>[git@localhost]cd ~

>[git@localhost]mkdir /home/git/repositories

>[git@localhost] chmod 755 /home/git/repositories




