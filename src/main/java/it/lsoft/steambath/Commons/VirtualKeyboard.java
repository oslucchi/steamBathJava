package it.lsoft.steambath.Commons;

import static java.awt.event.KeyEvent.VK_ALT;
import static java.awt.event.KeyEvent.VK_CAPS_LOCK;
import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_NUM_LOCK;
import static java.awt.event.KeyEvent.VK_SCROLL_LOCK;
import static java.awt.event.KeyEvent.VK_SHIFT;
import static java.awt.event.KeyEvent.VK_WINDOWS;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VirtualKeyboard extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static Color SELECTED_COLOR = new Color(-15304792); //Dark Sky blue
    private final static Color DEFAULT_KEY_COLOR = Color.darkGray; //new Color(-13421773);//Color.GRAY;
    private static boolean IS_FUNCTION_KEY_PRESSED = false;

    private javax.swing.JPanel numpadPanel;
    private javax.swing.JLabel keynum0;
    private javax.swing.JLabel keynum1;
    private javax.swing.JLabel keynum2;
    private javax.swing.JLabel keynum3;
    private javax.swing.JLabel keynum4;
    private javax.swing.JLabel keynum5;
    private javax.swing.JLabel keynum6;
    private javax.swing.JLabel keynum7;
    private javax.swing.JLabel keynum8;
    private javax.swing.JLabel keynum9;
    private javax.swing.JLabel keynumdivide;
    private javax.swing.JLabel keynumdot;
    private javax.swing.JLabel keynumenter;
    private javax.swing.JLabel keynumminus;
    private javax.swing.JLabel keynummult;
    private javax.swing.JLabel keynumplus;

    public VirtualKeyboard()
    {
		setUndecorated(true);
		setAlwaysOnTop(true);
		setAutoRequestFocus(false);
		setFocusableWindowState(false);
		setLayout(null);
    	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.darkGray);
        setFocusable(false);
        setResizable(false);

    	initComponents();
    	pack();
    }
    
    /**
     * Performs a key press event on the specific key. Sends a key pressed event 
     * to the current foreground application.
     * @param evt 
     */
    private void keyPressed(MouseEvent evt) {
        JLabel key = (JLabel)evt.getSource();
        key.setBackground(SELECTED_COLOR);
    }
    
    /**
     * Releases a key that was pressed. Sends a key release event to the current
     * foreground application.
     * @param evt 
     */
    private void keyReleased(MouseEvent evt) {
        JLabel key = (JLabel)evt.getSource();
        key.setBackground(DEFAULT_KEY_COLOR);
    }
    
    /**
     * Performs a mouse click event on the key. Mouse click generally send a key associated
     * with the source of the event object to the currently focusable foreground application.
     * @param evt 
     */
    private void keyClicked(MouseEvent evt) {
        JLabel key = (JLabel)evt.getSource();           //Source clicked key.
        int keycode = Integer.decode(key.getName());    //Virtual key code associated with the key
        boolean specialkey = false;
        
        /**
         * Check for special keys(e.g. CapsLock, NumLock, Shift key). Perform special
         * actions on special keys click such as pressing, or releasing a pressed key.
         */
        switch(keycode) {
            case VK_SHIFT:
                if (Keyboard.isShiftPressed()) 
                    Keyboard.releaseKey(VK_SHIFT);
                else 
                    Keyboard.pressKey(VK_SHIFT);
                specialkey = true;
                break;
            case VK_CONTROL:
                if (Keyboard.isCtrlPressed())
                    Keyboard.releaseKey(VK_CONTROL);
                else
                    Keyboard.pressKey(VK_CONTROL);
                specialkey = true;
                break;
            case VK_ALT:
                if(Keyboard.isAltPressed())
                    Keyboard.releaseKey(VK_ALT);
                else
                    Keyboard.pressKey(VK_ALT);
                specialkey = true;
                break;
            case VK_WINDOWS:
                if(Keyboard.isWinPressed())
                    Keyboard.releaseKey(VK_WINDOWS);
                else
                    Keyboard.pressKey(VK_WINDOWS);
                specialkey = true;
                break;
            case VK_CAPS_LOCK:
                Keyboard.typeKey(VK_CAPS_LOCK);
                specialkey = true;
                break;
            case VK_NUM_LOCK:
                Keyboard.typeKey(VK_NUM_LOCK);
                specialkey = true;
                break;
            case VK_SCROLL_LOCK:
                Keyboard.typeKey(VK_SCROLL_LOCK);
                specialkey = true;
                break;
            case 0xff: //Function key pressed
                IS_FUNCTION_KEY_PRESSED = !IS_FUNCTION_KEY_PRESSED;
                specialkey = true;
                break;
        }
        
        if(!specialkey) {
            Keyboard.typeKey(keycode);
            Keyboard.releaseAllSpecialKeys();
        }
    }
    
    /**
     * Performs a hover effect on the key button.
     * @param evt 
     */
    private void keyMouseEntered(MouseEvent evt) {
        JLabel source = (JLabel) evt.getSource();
        
        /**
         * Check if the current key is a special key or not.
         * Perform no hover effect if special keys(e.g. CapsLock, NumLock, Shift etc)
         * keys are pressed.
         */
        int keycode = Integer.decode(source.getName());
        switch(keycode) {
            case VK_SHIFT:
                if(Keyboard.isShiftPressed())
                    return;
                break;
            case VK_CONTROL:
                if(Keyboard.isCtrlPressed())
                    return;
                break;
            case VK_ALT:
                if(Keyboard.isAltPressed())
                    return;
                break;
            case VK_WINDOWS:
                if(Keyboard.isWinPressed())
                    return;
                break;
            case VK_CAPS_LOCK:
                if(Keyboard.isCapsLockOn())
                    return;
                break;
            case VK_NUM_LOCK:
                if(Keyboard.isNumLockOn())
                    return;
                break;
            case VK_SCROLL_LOCK:
                if(Keyboard.isScrollLockOn())
                    return;
                break;
            case 0xff: //If the function key is pressed
                if(IS_FUNCTION_KEY_PRESSED)
                    return;
        }
        
        source.setBackground(Color.GRAY);
    }
    
    /**
     * Performs a hover effect on the key button.
     * @param evt 
     */
    private void keyMouseExited(MouseEvent evt) {
        JLabel source = (JLabel) evt.getSource();
        
        /**
         * Check if the current key is special key or not.
         * Perform no hover effect if the special keys(e.g. CapsLock, NumLock, Shift key etc)
         * are pressed.
         */
        int keycode = Integer.decode(source.getName());
        switch(keycode) {
            case VK_SHIFT:
                if(Keyboard.isShiftPressed())
                    return;
                break;
            case VK_CONTROL:
                if(Keyboard.isCtrlPressed())
                    return;
                break;
            case VK_ALT:
                if(Keyboard.isAltPressed())
                    return;
                break;
            case VK_WINDOWS:
                if(Keyboard.isWinPressed())
                    return;
                break;
            case VK_CAPS_LOCK:
                if(Keyboard.isCapsLockOn())
                    return;
                break;
            case VK_NUM_LOCK:
                if(Keyboard.isNumLockOn())
                    return;
                break;
            case VK_SCROLL_LOCK:
                if(Keyboard.isScrollLockOn())
                    return;
                break;
            case 0xff: //If the function key is pressed
                if(IS_FUNCTION_KEY_PRESSED)
                    return;
        }
        
        source.setBackground(DEFAULT_KEY_COLOR);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        numpadPanel = new javax.swing.JPanel();
        keynumdivide = new javax.swing.JLabel();
        keynummult = new javax.swing.JLabel();
        keynumminus = new javax.swing.JLabel();
        keynum7 = new javax.swing.JLabel();
        keynum8 = new javax.swing.JLabel();
        keynum9 = new javax.swing.JLabel();
        keynumplus = new javax.swing.JLabel();
        keynum5 = new javax.swing.JLabel();
        keynum6 = new javax.swing.JLabel();
        keynum4 = new javax.swing.JLabel();
        keynum3 = new javax.swing.JLabel();
        keynum2 = new javax.swing.JLabel();
        keynum1 = new javax.swing.JLabel();
        keynumenter = new javax.swing.JLabel();
        keynumdot = new javax.swing.JLabel();
        keynum0 = new javax.swing.JLabel();

        numpadPanel.setBackground(java.awt.Color.darkGray);
        keynumdivide.setBackground(DEFAULT_KEY_COLOR);
        keynumdivide.setForeground(java.awt.Color.white);
        keynumdivide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynumdivide.setText("/");
        keynumdivide.setFocusable(false);
        keynumdivide.setMaximumSize(new java.awt.Dimension(40, 40));
        keynumdivide.setMinimumSize(new java.awt.Dimension(40, 40));
        keynumdivide.setName("0x6F"); // NOI18N
        keynumdivide.setOpaque(true);
        keynumdivide.setPreferredSize(new java.awt.Dimension(40, 40));
        keynumdivide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynummult.setBackground(DEFAULT_KEY_COLOR);
        keynummult.setForeground(java.awt.Color.white);
        keynummult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynummult.setText("*");
        keynummult.setFocusable(false);
        keynummult.setMaximumSize(new java.awt.Dimension(40, 40));
        keynummult.setMinimumSize(new java.awt.Dimension(40, 40));
        keynummult.setName("0x6A"); // NOI18N
        keynummult.setOpaque(true);
        keynummult.setPreferredSize(new java.awt.Dimension(40, 40));
        keynummult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynumminus.setBackground(DEFAULT_KEY_COLOR);
        keynumminus.setForeground(java.awt.Color.white);
        keynumminus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynumminus.setText("-");
        keynumminus.setFocusable(false);
        keynumminus.setMaximumSize(new java.awt.Dimension(40, 40));
        keynumminus.setMinimumSize(new java.awt.Dimension(40, 40));
        keynumminus.setName("0x2D"); // NOI18N
        keynumminus.setOpaque(true);
        keynumminus.setPreferredSize(new java.awt.Dimension(40, 40));
        keynumminus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynum7.setBackground(DEFAULT_KEY_COLOR);
        keynum7.setForeground(java.awt.Color.white);
        keynum7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynum7.setText("7");
        keynum7.setFocusable(false);
        keynum7.setMaximumSize(new java.awt.Dimension(40, 40));
        keynum7.setMinimumSize(new java.awt.Dimension(40, 40));
        keynum7.setName("0x67"); // NOI18N
        keynum7.setOpaque(true);
        keynum7.setPreferredSize(new java.awt.Dimension(40, 40));
        keynum7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynum8.setBackground(DEFAULT_KEY_COLOR);
        keynum8.setForeground(java.awt.Color.white);
        keynum8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynum8.setText("8");
        keynum8.setFocusable(false);
        keynum8.setMaximumSize(new java.awt.Dimension(40, 40));
        keynum8.setMinimumSize(new java.awt.Dimension(40, 40));
        keynum8.setName("0x68"); // NOI18N
        keynum8.setOpaque(true);
        keynum8.setPreferredSize(new java.awt.Dimension(40, 40));
        keynum8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynum9.setBackground(DEFAULT_KEY_COLOR);
        keynum9.setForeground(java.awt.Color.white);
        keynum9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynum9.setText("9");
        keynum9.setFocusable(false);
        keynum9.setMaximumSize(new java.awt.Dimension(40, 40));
        keynum9.setMinimumSize(new java.awt.Dimension(40, 40));
        keynum9.setName("0x69"); // NOI18N
        keynum9.setOpaque(true);
        keynum9.setPreferredSize(new java.awt.Dimension(40, 40));
        keynum9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynumplus.setBackground(DEFAULT_KEY_COLOR);
        keynumplus.setForeground(java.awt.Color.white);
        keynumplus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynumplus.setText("+");
        keynumplus.setFocusable(false);
        keynumplus.setMaximumSize(new java.awt.Dimension(40, 40));
        keynumplus.setMinimumSize(new java.awt.Dimension(40, 40));
        keynumplus.setName("0x6B"); // NOI18N
        keynumplus.setOpaque(true);
        keynumplus.setPreferredSize(new java.awt.Dimension(40, 40));
        keynumplus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynum5.setBackground(DEFAULT_KEY_COLOR);
        keynum5.setForeground(java.awt.Color.white);
        keynum5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynum5.setText("5");
        keynum5.setFocusable(false);
        keynum5.setMaximumSize(new java.awt.Dimension(40, 40));
        keynum5.setMinimumSize(new java.awt.Dimension(40, 40));
        keynum5.setName("0x65"); // NOI18N
        keynum5.setOpaque(true);
        keynum5.setPreferredSize(new java.awt.Dimension(40, 40));
        keynum5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynum6.setBackground(DEFAULT_KEY_COLOR);
        keynum6.setForeground(java.awt.Color.white);
        keynum6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynum6.setText("6");
        keynum6.setFocusable(false);
        keynum6.setMaximumSize(new java.awt.Dimension(40, 40));
        keynum6.setMinimumSize(new java.awt.Dimension(40, 40));
        keynum6.setName("0x66"); // NOI18N
        keynum6.setOpaque(true);
        keynum6.setPreferredSize(new java.awt.Dimension(40, 40));
        keynum6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynum4.setBackground(DEFAULT_KEY_COLOR);
        keynum4.setForeground(java.awt.Color.white);
        keynum4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynum4.setText("4");
        keynum4.setFocusable(false);
        keynum4.setMaximumSize(new java.awt.Dimension(40, 40));
        keynum4.setMinimumSize(new java.awt.Dimension(40, 40));
        keynum4.setName("0x64"); // NOI18N
        keynum4.setOpaque(true);
        keynum4.setPreferredSize(new java.awt.Dimension(40, 40));
        keynum4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynum3.setBackground(DEFAULT_KEY_COLOR);
        keynum3.setForeground(java.awt.Color.white);
        keynum3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynum3.setText("3");
        keynum3.setFocusable(false);
        keynum3.setMaximumSize(new java.awt.Dimension(40, 40));
        keynum3.setMinimumSize(new java.awt.Dimension(40, 40));
        keynum3.setName("0x63"); // NOI18N
        keynum3.setOpaque(true);
        keynum3.setPreferredSize(new java.awt.Dimension(40, 40));
        keynum3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynum2.setBackground(DEFAULT_KEY_COLOR);
        keynum2.setForeground(java.awt.Color.white);
        keynum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynum2.setText("2");
        keynum2.setFocusable(false);
        keynum2.setMaximumSize(new java.awt.Dimension(40, 40));
        keynum2.setMinimumSize(new java.awt.Dimension(40, 40));
        keynum2.setName("0x62"); // NOI18N
        keynum2.setOpaque(true);
        keynum2.setPreferredSize(new java.awt.Dimension(40, 40));
        keynum2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynum1.setBackground(DEFAULT_KEY_COLOR);
        keynum1.setForeground(java.awt.Color.white);
        keynum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynum1.setText("1");
        keynum1.setFocusable(false);
        keynum1.setMaximumSize(new java.awt.Dimension(40, 40));
        keynum1.setMinimumSize(new java.awt.Dimension(40, 40));
        keynum1.setName("0x61"); // NOI18N
        keynum1.setOpaque(true);
        keynum1.setPreferredSize(new java.awt.Dimension(40, 40));
        keynum1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynumenter.setBackground(DEFAULT_KEY_COLOR);
        keynumenter.setForeground(java.awt.Color.white);
        keynumenter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynumenter.setText("Enter");
        keynumenter.setFocusable(false);
        keynumenter.setMaximumSize(new java.awt.Dimension(40, 86));
        keynumenter.setMinimumSize(new java.awt.Dimension(40, 86));
        keynumenter.setName("0x0A"); // NOI18N
        keynumenter.setOpaque(true);
        keynumenter.setPreferredSize(new java.awt.Dimension(40, 86));
        keynumenter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynumdot.setBackground(DEFAULT_KEY_COLOR);
        keynumdot.setForeground(java.awt.Color.white);
        keynumdot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynumdot.setText(".");
        keynumdot.setFocusable(false);
        keynumdot.setMaximumSize(new java.awt.Dimension(40, 40));
        keynumdot.setMinimumSize(new java.awt.Dimension(40, 40));
        keynumdot.setName("0x6E"); // NOI18N
        keynumdot.setOpaque(true);
        keynumdot.setPreferredSize(new java.awt.Dimension(40, 40));
        keynumdot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        keynum0.setBackground(DEFAULT_KEY_COLOR);
        keynum0.setForeground(java.awt.Color.white);
        keynum0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keynum0.setText("0");
        keynum0.setFocusable(false);
        keynum0.setMaximumSize(new java.awt.Dimension(86, 40));
        keynum0.setMinimumSize(new java.awt.Dimension(86, 40));
        keynum0.setName("0x60"); // NOI18N
        keynum0.setOpaque(true);
        keynum0.setPreferredSize(new java.awt.Dimension(86, 40));
        keynum0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                keyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                keyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                keyPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                keyReleased(evt);
            }
        });

        javax.swing.GroupLayout numpadPanelLayout = new javax.swing.GroupLayout(numpadPanel);
        numpadPanel.setLayout(numpadPanelLayout);
        numpadPanelLayout.setHorizontalGroup(
            numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numpadPanelLayout.createSequentialGroup()
                .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(numpadPanelLayout.createSequentialGroup()
                        .addComponent(keynum1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(keynum2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(keynum0, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keynum3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keynumdot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(keynumenter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(numpadPanelLayout.createSequentialGroup()
                    .addComponent(keynumdivide, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(4, 4, 4)
                    .addComponent(keynummult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(4, 4, 4)
                    .addComponent(keynumminus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(numpadPanelLayout.createSequentialGroup()
                    .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(numpadPanelLayout.createSequentialGroup()
                            .addComponent(keynum7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(keynum8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(keynum9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(numpadPanelLayout.createSequentialGroup()
                            .addComponent(keynum4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(keynum5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(keynum6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(4, 4, 4)
                    .addComponent(keynumplus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        numpadPanelLayout.setVerticalGroup(
            numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numpadPanelLayout.createSequentialGroup()
                .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keynumdivide, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(keynumminus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(keynummult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(numpadPanelLayout.createSequentialGroup()
                        .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keynum7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keynum8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keynum9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keynum4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keynum5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keynum6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(keynumplus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(numpadPanelLayout.createSequentialGroup()
                        .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keynum1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keynum2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keynum3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(numpadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keynumdot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keynum0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(keynumenter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(numpadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(numpadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }
}
