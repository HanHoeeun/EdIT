package com.itwillbs.domain;

public class WishListDTO {
 
	private int w_num;
	private int w_p_num;
	private int w_m_num;
	private MemberDTO memberDTO;
    private ProductDTO productDTO;

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
	
	public int getW_num() {
		return w_num;
	}
	public void setW_num(int w_num) {
		this.w_num = w_num;
	}
	public int getW_p_num() {
		return w_p_num;
	}
	public void setW_p_num(int w_p_num) {
		this.w_p_num = w_p_num;
	}
	public int getW_m_num() {
		return w_m_num;
	}
	public void setW_m_num(int w_m_num) {
		this.w_m_num = w_m_num;
	}
	
	
}
