package com.bean;

import java.util.List;

/**
 * Created by lipy on 2017/9/26.
 */

public class LoginRes implements DataObject {



    private String Authorization;
    private UserBean user;

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String Authorization) {
        this.Authorization = Authorization;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean implements DataObject{


        private int id;
        private String username;
        private String nick;
        private String loginName;
        private String oldLoginName;
        private String initPassword;
        private String password;
        private int sex;
        private String birthday;
        private String phone;
        private String email;
        private String weixin;
        private String qq;
        private boolean isEmailEnabled;
        private boolean isEnabled;
        private boolean isFrozen;
        private String photoUrl;
        private boolean isDeleted;
        private String createdBy;
        private String createdOn;
        private String modifiedBy;
        private String modifiedOn;
        private String regDate;
        private String regType;
        private int lastRoleApp;
        private String lastRoleWeb;
        private boolean frozen;
        private boolean enabled;
        private boolean emailEnabled;
        private boolean deleted;
        private List<RolesBean> roles;
        private List<MenusBean> menus;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getOldLoginName() {
            return oldLoginName;
        }

        public void setOldLoginName(String oldLoginName) {
            this.oldLoginName = oldLoginName;
        }

        public String getInitPassword() {
            return initPassword;
        }

        public void setInitPassword(String initPassword) {
            this.initPassword = initPassword;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getWeixin() {
            return weixin;
        }

        public void setWeixin(String weixin) {
            this.weixin = weixin;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public boolean isIsEmailEnabled() {
            return isEmailEnabled;
        }

        public void setIsEmailEnabled(boolean isEmailEnabled) {
            this.isEmailEnabled = isEmailEnabled;
        }

        public boolean isIsEnabled() {
            return isEnabled;
        }

        public void setIsEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
        }

        public boolean isIsFrozen() {
            return isFrozen;
        }

        public void setIsFrozen(boolean isFrozen) {
            this.isFrozen = isFrozen;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public boolean isIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getCreatedOn() {
            return createdOn;
        }

        public void setCreatedOn(String createdOn) {
            this.createdOn = createdOn;
        }

        public String getModifiedBy() {
            return modifiedBy;
        }

        public void setModifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
        }

        public String getModifiedOn() {
            return modifiedOn;
        }

        public void setModifiedOn(String modifiedOn) {
            this.modifiedOn = modifiedOn;
        }

        public String getRegDate() {
            return regDate;
        }

        public void setRegDate(String regDate) {
            this.regDate = regDate;
        }

        public String getRegType() {
            return regType;
        }

        public void setRegType(String regType) {
            this.regType = regType;
        }

        public int getLastRoleApp() {
            return lastRoleApp;
        }

        public void setLastRoleApp(int lastRoleApp) {
            this.lastRoleApp = lastRoleApp;
        }

        public String getLastRoleWeb() {
            return lastRoleWeb;
        }

        public void setLastRoleWeb(String lastRoleWeb) {
            this.lastRoleWeb = lastRoleWeb;
        }

        public boolean isFrozen() {
            return frozen;
        }

        public void setFrozen(boolean frozen) {
            this.frozen = frozen;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public boolean isEmailEnabled() {
            return emailEnabled;
        }

        public void setEmailEnabled(boolean emailEnabled) {
            this.emailEnabled = emailEnabled;
        }

        public boolean isDeleted() {
            return deleted;
        }

        public void setDeleted(boolean deleted) {
            this.deleted = deleted;
        }

        public List<RolesBean> getRoles() {
            return roles;
        }

        public void setRoles(List<RolesBean> roles) {
            this.roles = roles;
        }

        public List<MenusBean> getMenus() {
            return menus;
        }

        public void setMenus(List<MenusBean> menus) {
            this.menus = menus;
        }

        public static class RolesBean implements DataObject{

            private int id;
            private String roleName;
            private String cname;
            private String comments;
            private String permissions;
            private String enabled;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getRoleName() {
                return roleName;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }

            public String getCname() {
                return cname;
            }

            public void setCname(String cname) {
                this.cname = cname;
            }

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }

            public String getPermissions() {
                return permissions;
            }

            public void setPermissions(String permissions) {
                this.permissions = permissions;
            }

            public String getEnabled() {
                return enabled;
            }

            public void setEnabled(String enabled) {
                this.enabled = enabled;
            }
        }

        public static class MenusBean implements DataObject{

            private int id;
            private String menuName;
            private String href;
            private String parentId;
            private int order;
            private String comments;
            private String child;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMenuName() {
                return menuName;
            }

            public void setMenuName(String menuName) {
                this.menuName = menuName;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }

            public String getChild() {
                return child;
            }

            public void setChild(String child) {
                this.child = child;
            }
        }
    }
}
