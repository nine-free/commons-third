### git基本命令


######

克隆代码到本地仓库
```
git clone 'git@github.com:nine-free/common-redis.git'

```
###### 创建repository

```
git init
```
###### 查看状态

```
git status
```
###### 提交到暂存区

```
git add file
```
###### 提交到分支

```
git commit -m "msg"
```
###### 本地修改推送到服务器

```
git push origin online:online
```
###### 查看命令历史

```
git reflog -n
```
###### 查看日志

```
git log -n
git log --pretty=oneline -n
```
###### 查看当前文件与暂存区文件区别

```
git diff file
```
###### 创建分支
```
git branch dev
git checkout dev
git push origin dev:dev
git checkout -b dev  # 相当于合并1&2操作
```
###### 删除本地分支
```
git branch -d dev
git branch -D dev
```
###### 删除远程分支

```
git push origin :dev
```
###### 合并代码
```
git checkout  master分支
git merge  dev分支
手动解决冲突
commit
```
###### 查看分支
```
git branch -r   查看看远程分支
git branch -a  查看所有分支
```
###### 版本回退
```
#本地回退到历史版本  版本id
git reset --hard  版本id
#强制推送到服务端
git push -f origin online:online
```
###### 暂存
```
git stash   暂存
git stash apply
git stash list
git stash clear
```










