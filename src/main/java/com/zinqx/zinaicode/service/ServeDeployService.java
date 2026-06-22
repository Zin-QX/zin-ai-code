package com.zinqx.zinaicode.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class ServeDeployService {
    
    private static final String CODE_BASE_DIR = "/tmp/deploy";
    private static final int SERVE_PORT = 3000;
    private static Process serveProcess;
    
    /**
     * 检查 npx 是否可用
     */
    private boolean isNpxAvailable() {
        try {
            ProcessBuilder pb = new ProcessBuilder();
            if (isWindows()) {
                pb.command("cmd", "/c", "where", "npx");
            } else {
                pb.command("which", "npx");
            }
            Process process = pb.start();
            process.waitFor(5, TimeUnit.SECONDS);
            return process.exitValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 判断是否为 Windows 系统
     */
    private boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("win");
    }
    
    /**
     * 启动 Serve 服务
     */
    public void startServeService() {
        try {
            // 检查 npx 是否可用
            if (!isNpxAvailable()) {
                System.err.println("警告: 未检测到 npx，请确保已安装 Node.js 并配置到环境变量中");
                System.err.println("如需使用部署功能，请执行: npm install -g serve");
                return;
            }
            
            if (serveProcess == null || !serveProcess.isAlive()) {
                ProcessBuilder pb = new ProcessBuilder();
                if (isWindows()) {
                    pb.command("cmd", "/c", "npx", "serve", CODE_BASE_DIR, "-p", String.valueOf(SERVE_PORT));
                } else {
                    pb.command("npx", "serve", CODE_BASE_DIR, "-p", String.valueOf(SERVE_PORT));
                }
                pb.redirectErrorStream(true);
                serveProcess = pb.start();
                System.out.println("Serve service started on port " + SERVE_PORT);
            }
        } catch (IOException e) {
            System.err.println("启动 Serve 服务失败: " + e.getMessage());
            System.err.println("请确保已安装 Node.js 和 serve 工具");
        } catch (Exception e) {
            System.err.println("启动 Serve 服务时发生错误: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * 关闭 Serve 服务
     */
    public void stopServeService() {
        if (serveProcess != null && serveProcess.isAlive()) {
            serveProcess.destroy();
            try {
                serveProcess.waitFor(5, TimeUnit.SECONDS);
                System.out.println("Serve service stopped");
            } catch (InterruptedException e) {
                serveProcess.destroyForcibly();
                System.out.println("Serve service force stopped");
            }
        }
    }
}
