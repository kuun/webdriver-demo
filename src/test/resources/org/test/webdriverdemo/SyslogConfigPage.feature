Feature: Syslog配置
  Background:
    Given 打开登录页面
    When 使用正确的用户名与密码登录
    Then 进入主页面

  Scenario: 正确启用Syslog
    Given 打开Syslog配置页面
    When 使用合法的参数启用Syslog
    Then Syslog启用成功
