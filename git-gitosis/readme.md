# centos 7 install git & gitosis

### install git

>[root@localhost] yum install git


### add git user

>[root@localhost] useradd -m git

### change git passwd

>[root@localhost] passwd git

### add git user to sudo 

>[root@localhost] visudo

#### insert to last line
>git    ALL=(ALL)       ALL

### su git

>[root@localhost] su git

### add git repositories folder

>[git@localhost] cd ~

>[git@localhost] mkdir repositories

>[git@localhost] sudo chmod 755 repositories

>[git@localhost] git config --global user.name "myname" 

>[git@localhost] git config --global user.email "myname@server"

>[git@localhost] git clone https://github.com/res0nat0r/gitosis.git

>[git@localhost] cd gitosis 

>[git@localhost] sudo python setup.py install

### add ssh key

>[git@localhost] cd ~

>[git@localhost] sh-keygen -t rsa -b 4096  

### enter enter enter

>[git@localhost] cd ~

>[git@localhost] cd .ssh

>[git@localhost] sudo -H -u git gitosis-init < id_rsa.pub

>[git@localhost] sudo chmod 755 /home/git/repositories/gitosis-admin.git/hooks/post-update

### manager gitosis

>[git@localhost] cd ~ 

>[git@localhost] git clone git@localhost:gitosis-admin.git

>[git@localhost] cd gitosis-admin


###install ok

## add gitosis user

### add visitor ssh key.

>[windows-git-bash] sh-keygen -t rsa -b 4096

### enter enter enter

### find the id_rsa.pub

>[windows-git-bash] cd ~/.ssh


### copy the id_rsa.pub to the server /home/git/id_rsa.pub

>[git@localhost] cd ~


>[git@localhost]  mv id_rsa.pub gitosis-admin/keydir/fun@git.pub

### gives the user access to the git directory permissions

>[git@localhost] cd gitosis-admin

>[git@localhost] vi giosis.conf

#### insert to last line
 
> [group dev]

  members = fun@git
  
  writable = code
  
  
#### save 

>[git@localhost] git add .

>[git@localhost] git commit -a -m "give fun access to the code directory permissions"

>[git@localhost] git push origin master

### user permission ok.

### and git code folder

>[git@localhost] cd ~/repositories

>[git@localhost] mkdir code.git

>[git@localhost] cd code.git

>[git@localhost] git init --bare

### folder ok.


### now you can try

>[windows-git-bash] git clone git@Ip:code

### see what happend

















